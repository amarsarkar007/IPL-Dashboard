import { React, useEffect, useState } from 'react';
import { useParams,Link } from 'react-router-dom';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';
// import PieChart from 'react-simple-pie-chart';
import { MyChart } from '../components/MyChart';




import './TeamPage.scss';


export const TeamPage = () => {


  const [team, setTeam] = useState({ matches: [] });
  const { teamName } = useParams();


  useEffect(

    () => {

      const fetchMatches = async () => {

        const response = await fetch(`http://localhost:8080/team/${teamName}`);
        const data = await response.json();
        // console.log(data);
        setTeam(data)

      };

      fetchMatches();



    }, [teamName]

  );

  if (!team || !team.teamName) {
    return <h2>Team not found</h2>
  }


  return (
    <div className="TeamPage">
      <div className='team-name-section'>
        <h1 className='team-name'>{team.teamName}</h1>
      </div>
      <div className='win-loss-section'>
        <p>wins / Losses</p>
        <div className='pie-chart'>

          <MyChart team ={team}/>

        </div>

      </div>
      {/* <div className='win-loss-section'>
        wins / Losses
        <div className='pie-chart'>

          <PieChart
            slices={[
              {
                color: '#229954',
                value: team.totalWins,
              },
              {
                color: '#C0392B',
                value: team.totalMatches - team.totalWins,
              },
            ]}
          />


        </div>

      </div> */}
      <div className='match-detail-section'>
        <h3>Latest Matches</h3>
        <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
      </div>
      {team.matches.slice(1).map(match => <MatchSmallCard key={match.id} teamName={team.teamName} match={match} />)}
      <div className='more-link'>
        <Link to={`/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}>More {'>'}</Link>
        {/* <a href='#'>More {'>'}</a> */}
      </div>
    </div>
  );
}


