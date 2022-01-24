
import React from "react";

import Image from "./Image"
import ButtonLogin  from "../../shared/ButtonLogin";

import "../../css/App.css"
import Desc from "./Desc";
import image_fitness from "../../css/image_fitness.jpg";
import { Grid } from '@mui/material';
import Title from "./Title";
import Offre from "./Offre";
import OneCard from "./card/OneCard";
import hajar from "../../css/hajar_photo.png";
import Obaydah from "../../css/Obaydah_photo.png";
import Mimoun from "../../css/Mimoun_photo.png";
import Adeel from "../../css/Adeel_photo.png";
import ensias from  "../../css/ENSIAS.png";
import img from "../../css/fitness.png"
import fitness2 from "../../css/fitness_coll.png"

function Home() {

  return (
    <div>
<Grid container spacing={3}>
  <Grid item xs />
  <Grid item xs={8}>
    < Title/>
  </Grid>
  <Grid item xs />
</Grid>
   
      <img src={image_fitness} alt="feuille" />
<Offre title="Check out our offers!"/>
      <Grid container >
      <Grid  item md={1} xs={1} />
      <Grid item md={5} xs={5} > <Desc txt1="Our application give
    you the opportunity to program online
  training sessions with the highly qualified coaches around the world." txt2="MEET FITNESS" txt3="afford for you a  multiplicity of coaching offers ! Sign in, Choose the coach of your dream  and start now ! "/></Grid>
      <Grid  item md={1} xs={1} />
<Grid item md={5} xs={5} >   <Image image={img}/></Grid>

      
</Grid>
<Grid container >
      <Grid  item md={2} xs={2} />
      <Grid item md={3} xs={4} >   <Image image={fitness2}/></Grid>
      <Grid item md={6} xs={4} > <Desc txt1="The application permit you to announce and organize a group sport session outside" txt3="It’s also an opportunity to meet new people and to motivate each others  "/></Grid>
      <Grid  item md={1} xs={1} />
     
</Grid>

<Offre title="How to create acount!"/>
<Grid container   justifyContent="space-between"  >
      <Grid  item md={1} xs={1} />
      <Grid item md={6} xs={6} > <Desc txt1="Either coach or player, you can simply create an account on  Meet fitness!"  txt3="If you have encountered any problem, don't hesitate to contact us on the contact support "/></Grid>
      <Grid  item md={2} xs={2} />


<Grid  container  direction="column" item md={3} xs={3}  > 
<Grid item md={4} xs={4} /> 
<Grid item  md={4} xs={4}>
 <ButtonLogin

name="Sign in  as a player"
href="/playersSignin"
 
/> </Grid>
<Grid item md={4} xs={4}>
 <ButtonLogin

name="Sign in  as a coach"
href="/CoachSignin"
 
/> </Grid>



</Grid>
</Grid>
<Grid  item container >
<Grid  item md={2} xs={2} />
<Grid  item md={8} xs={8}>
<Offre title="Who we are ?"/> </Grid>
<Grid  item md={2} xs={2} />
</Grid>

<Grid container >
      <Grid  item md={1} xs={1} />
      <Grid item md={5} xs={5} > <Desc txt1="This application is an academic project in ENSIAS (National School of Computer Science and System Analysis) ." txt2="MEET FITNESS App"  txt3="is  a result of a hard and a serious work done by 4 Students. Don't hesitate to contact us !
We are looking to collaborate on any project we could get experience from!
"/></Grid>
      <Grid  item md={1} xs={1} />
<Grid item md={5} xs={5} >   <Image image={ensias}/></Grid>
</Grid>
<Offre title=" Contact The app developers"/>
<Grid container   
   >
    
<Grid item md={2} xs={2} />
  <Grid item md={4} xs={4}>
  <OneCard  name="Obaydah BOUIFADENE" photo={Obaydah} github="https://github.com/oubaydos" LinkedIn="https://www.linkedin.com/in/oubaydos/"/>
  </Grid>
  <Grid item md={4} xs={4}>
  <OneCard  name="Hajar DAMI" photo={hajar} github="https://github.com/hajardami" LinkedIn="https://www.linkedin.com/in/hajar-dami-680a5b1a0/"/>
  </Grid>
  <Grid item md={2} xs={2} />
  <Grid item md={2} xs={2} />
  <Grid item md={4} xs={4}>
  <OneCard  name="Abdelhalim AADEL" photo={Adeel} LinkedIn= "https://www.linkedin.com/in/abdelhalim-aadel-72788a200/?originalSubdomain=ma"/>
  </Grid>
  <Grid item md={4} xs={4}>
  <OneCard  name="Mimoun GHORDOU" photo={Mimoun} LinkedIn="https://www.linkedin.com/in/mimoun-ghordou-38ba05201/"/>
  <Grid item md={2} xs={2} />
  </Grid>
</Grid>



    </div>
  );
}
export default Home;
/*<MyButton
bgColor="#316300"
fgColor="white"
className={style.but2}
value="Register  as a player"
url="/Register" 
/> <MyButton
      bgColor="#316300"
      fgColor="white"
      className={style.butt1}
      value="Register as a coach"
      url="/Register" 
    />
    
<Grid container   justifyContent="space-between"
   >
<Grid item md={2} xs={2}></Grid>
  <Grid item md={4} xs={4}>
  <OneCard  name="Obaydah BOUIFADENE" photo={Obaydah}/>
  </Grid>
  <Grid item md={4} xs={4}>
  <OneCard  name="Hajar DAMI" photo={hajar}/>
  </Grid>
  <Grid item md={2} xs={2}></Grid>
  <Grid item md={2} xs={2}></Grid>
  <Grid item md={4} xs={4}>
  <OneCard  name="Abdelhalim AADEL" photo={Adeel}/>
  </Grid>
  <Grid item md={4} xs={4}>
  <OneCard  name="Mimoun GHORDOU" photo={Mimoun}/>
  <Grid item md={2} xs={2}></Grid>
  </Grid>
</Grid>*/