import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { MatchDetailCard } from '../components/MatchDetailCard';
// import { MatchSmallCard } from '../components/MatchSmallCard';

import './MatchPage.scss';
import { YearSelector } from '../components/YearSelector';



export const MatchPage = () => {

    const [matches, setMatches] = useState([]);
    const {teamName,year} = useParams();
    // const teamName = "Chennai Super Kings"
    // const year = "2019"
  
    useEffect(
  
      () => {
  
        const fetchMatches = async () => {
  
          const response = await fetch(`http://localhost:8080/team/${teamName}/matches?year=${year}`);
          const data = await response.json();
          // console.log(data);
          setMatches(data)
  
        };
  
        fetchMatches();
  
  
  
      },[teamName,year]
  
    );


  return (
    <div className="MatchPage">

        <div className='year-selector'>
          <h3>Select year</h3>
          <YearSelector teamName={teamName}/>

        </div>

        <div>
          <h1>{teamName} matches in {year}</h1>
          {matches.map(match => <MatchDetailCard key={match.id} teamName={teamName} match={match} />)}
        </div>
      
    </div>
  );
}


