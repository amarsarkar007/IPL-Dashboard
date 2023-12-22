import { React } from 'react';
import { Link } from 'react-router-dom';

import "./MatchDatailCard.scss";


export const MatchDetailCard = ({match,teamName}) => {

  if(!match) return null;

  const otherTeam = match.team1 === teamName ? match.team2 : match.team1 ;
  const otherTeamRoute = `/teams/${otherTeam}`;

  const isMatchWon = teamName === match.winningTeam;

  return (
    <div className={isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
      <div>
        <span className='vs'>vs</span>
        <h2><Link to={otherTeamRoute}>{otherTeam}</Link></h2>
        <h3 className='match-date'>{match.date}</h3>
        <p className='match-venue'>at {match.venue}</p>
        <h3 className='match-result'>{match.winningTeam} won by {match.margin} {match.result}</h3>
      </div>
      <div className='additional-details'>
        <p>#{match.matchNumber}</p>
        <h3>1st Innings</h3>
        <p>{match.team1}</p>
        <h3>2nd Innings</h3>
        <p>{match.team2}</p>
        <h3>Man of the match</h3>
        <p>{match.playerOfMatch}</p>
        <h3>Umpires</h3>
        <p>{match.umpire1}, {match.umpire2}</p>
      </div>
    </div>
  );
}
