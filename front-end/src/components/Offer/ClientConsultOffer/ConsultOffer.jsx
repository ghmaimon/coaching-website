import * as React from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import ProfilCard from "../../Dashboard/Coach/ProfilCard"

import coach from "../../../css/coach.jpg"
import OfferTitle from "./OfferTitle"
import Description from "./Description"
import {JoinOffer, Payment, ContactCoach} from "./Buttons";
import MoreInfo from "./MoreInfo";

function sendEmail() 
{
    window.location = "mailto:xyz@yourapplicationdomain.com";
}


export default function ConsultOffer(props) {
    return( <div>
<Grid container >
   
<Grid item xs={4}></Grid>
<Grid item xs={4}> <OfferTitle  title={props.title}/></Grid>
<Grid item xs={4}></Grid>
   
<Grid item container xs={12}> 

<Grid item container xs={5}>

    <Grid  container xs={12}>
    <Grid item xs={2}></Grid>
    <Grid item xs={6}>
      <p style={{fontFamily:"Rubik Beastly",
       
      
       lineHeight: "1,4",
         fontSize: "25px",
     
      fontWeight: "300",
    
     
     }}>Offer Description</p>
</Grid>
<Grid item xs={2}></Grid>
     </Grid>
     
     <Grid item xs={12}>    <Description desc={props.desc} /></Grid>
     
     </Grid>
<Grid item container xs={7}>
<Grid item  container xs={12}>
<Grid item xs={4}></Grid>
<Grid item xs={4}>
      <p style={{fontFamily:"Rubik Beastly",
       
      
       lineHeight: "1,4",
         fontSize: "25px",
     
      fontWeight: "300",
    
     
     }}>who is the coach !!</p> </Grid>
<Grid item xs={4}></Grid>
     </Grid>


  <Grid item xs={12}>
  <ProfilCard
  name={props.name}
  photo={props.photo}
  email={props.email}
  speciality={props.speciality}
  level={props.level}
              

               />
  
  </Grid>


</Grid>



 </Grid>
 <Grid item container xs={6}>
 <Grid item xs={2}></Grid>
     <Grid item xs={6}>
         
 <p style={{fontFamily:"Rubik Beastly",
       
      
       lineHeight: "1,4",
         fontSize: "25px",
     
      fontWeight: "300",
    
     
     }}>More information !!</p>
     <Grid item xs={4}></Grid>

    
</Grid>

<Grid item  xs={12}>
<MoreInfo  date ={props.date} maxPrice ={props.maxPrice} minPrice={props.minPrice} ></MoreInfo>
</Grid>
</Grid>

 <Grid item container xs={6}> 

 <Grid item xs={2}></Grid>
 <Grid item xs={8}>
         
 <p style={{fontFamily:"Rubik Beastly",
       
      
       lineHeight: "1,4",
         fontSize: "25px",
     
      fontWeight: "300",
    
     
     }}>Contact the coach</p>
     <Grid item xs={2}></Grid>
</Grid>
<Grid container item xs={12}>

 


     <Grid item xs={4} > </Grid>
     <Grid item xs={4} >  <ContactCoach email ={props.email}/></Grid>
     <Grid item xs={4} ></Grid>

</Grid>
 
 
 

               
                </Grid> 

</Grid>



    </div>
      
        
        )
    
}