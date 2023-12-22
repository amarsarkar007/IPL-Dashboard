import { React } from 'react';
import { Link } from 'react-router-dom';

import "./MatchSmallCard.scss";


export const MatchSmallCard = ({match, teamName}) => {
  // if(!match) return null;

  const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
  const otherTeamRoute = `/teams/${otherTeam}`;

  const isMatchWon = teamName === match.winningTeam;

  return (
    <div className={isMatchWon ? 'MatchSmallCard won-card' : 'MatchSmallCard lost-card'}>
      <span className='vs'>vs</span>
      <h2><Link to={otherTeamRoute}>{otherTeam}</Link></h2>
      <p className='match-result'>{match.winningTeam} won by {match.margin} {match.result}</p>
    </div>
  );
}
