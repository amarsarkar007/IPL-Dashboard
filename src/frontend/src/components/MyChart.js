import React from 'react';
import { Pie, Doughnut } from 'react-chartjs-2';
import {Chart, ArcElement,Tooltip } from 'chart.js'
Chart.register(Tooltip);
Chart.register(ArcElement);




export const MyChart = ({team}) => {
    // Your chart data and options go here
    const state = {
        labels: ['Won ','Lost '],
        datasets: [
          {
            backgroundColor: [
              '#229954',
              '#C0392B',
              
            ],
            hoverBackgroundColor: [
            '#097054',
            '#501800'
            
            ],
            data: [team.totalWins, team.totalMatches-team.totalWins]
          }
        ]
      }
  
    const options = {
        // responsive: true,
        // showTooltips: true,
        plugins: {
            tooltip: {
              enabled: true,
              callbacks: {
                label: (context) => {
                  return `${context.label}: ${context.formattedValue}`;
                },
                title: (context) => {
                  return null; // To hide the default title (color - label)
                },
              },
            },
          }
      }
  
    return (
      <div>
        <Doughnut data={state} options={options} />
      </div>
    );
  };
  

  