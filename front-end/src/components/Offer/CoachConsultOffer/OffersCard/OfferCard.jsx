import React from "react";
import hajar_photo from "../../../../css/coach.jpg";
import styled from "styled-components";
import TextButton from "../../../../shared/TextButton"
import Grid from "@mui/material/Grid";

 function OfferCard(props){
  const Container = styled.div`
 width: 100%;
  max-width: 80%;
  background:#FFFFFF;
  padding: 44px;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
  text-align: left;
  border-radius: 4px;
 
`;

const Img = styled.img`
  height: 200px;
 


`;

const Test1 = styled.h5`
color: #ed563b;
margin: 0 0 0 0;
font-weight: 500;
font-size: 14px
 
`;

const Test2 = styled.h3`
color: rgba(15, 103, 8, 1);
letter-spacing: 1px;
fontFamily: "Rubik Beastly";
font-size: 40px;
margin-left: 20%;

  }
`;

const Test3 = styled.p`
margin: 0 0 0 0;
    color: #7a7a7a;
    font-size: 20px;
    font-weight: 400;
    line-height: 1.7;
  

    

`; 

const Test4 = styled.h3`
letter-spacing: 1px;
fontFamily: "Rubik Beastly";
font-size: 60px;


  }
`;
return (
  <Container>
    <Grid container >

      <Grid container item xs={12}>
<Grid item container  xs={6}>

  <Grid item xs={12}>
   <p style={{
fontFamily: "Rubik Beastly",
fontWeight: "500",
fontSize: "20px"}}

>
  {props.title}</p> 
   </Grid>

  <Grid item xs={12}>
<h3 style={{letterSpacing: "1px",

fontSize: "60px"}}>{props.name}</h3>  
</Grid>

<Grid item xs={12}>
<Test3>{props.desc}</Test3>
</Grid>

<Grid item xs={12}> <Test1>{props.price}</Test1>
</Grid>

</Grid>

 <Grid item container xs={6}>  
 <Grid item xs={12}></Grid>
 <Grid item xs={2}></Grid>
 <Img   src={props.image} alt="trainer" /> 
       </Grid>
      </Grid>
      </Grid>

 < TextButton value="delete Offer"  fgColor="rgba(15, 103, 8, 1)"   url={props.url}  onClick={props.delete}> </TextButton>
 < TextButton value="Clients"  fgColor="rgba(15, 103, 8, 1)"   url="/offers/clients"  > </TextButton>
 
   </Container>);
}


export default OfferCard;

