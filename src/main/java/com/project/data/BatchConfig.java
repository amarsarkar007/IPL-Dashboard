package com.project.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.project.model.Match;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	private final String[] FIELD_NAMES = new String[] {
			"ID","City","Date","Season","MatchNumber","Team1","Team2","Venue","TossWinner","TossDecision","SuperOver","WinningTeam","WonBy","Margin","method","Player_of_Match","Team1Players","Team2Players","Umpire1","Umpire2"
	};
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Bean
    public FlatFileItemReader<MatchInput> reader() {
        return new FlatFileItemReaderBuilder<MatchInput>()
        		.name("MatchItemReader")
                .resource(new ClassPathResource("match-data.csv"))
                .linesToSkip(1)
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>() {
                    {
                        setTargetType(MatchInput.class);
                    }
                }).build();
    }
    
    @Bean
    public MatchDataProcessor processor() {
        return new MatchDataProcessor();
    }
    
    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO match(ID, City, Date, Season, Match_number, Team1, Team2, Venue, Player_of_Match, Toss_winner, Toss_decision, Winning_team, result, Margin, Umpire1, Umpire2, Super_over, Team1players, Team2players) VALUES(:id, :city, :date, :season, :matchNumber, :team1, :team2, :venue, :playerOfMatch, :tossWinner, :tossDecision, :winningTeam, :result, :margin, :umpire1, :umpire2, :superOver, :team1Players, :team2Players)")
                .dataSource(dataSource).build();
    }
    
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory
            .get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }
    
    @Bean
    public Step step1(JdbcBatchItemWriter<Match> writer) {
        return stepBuilderFactory
            .get("step1")
            .<MatchInput, Match>chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
    
    
    
    


}
