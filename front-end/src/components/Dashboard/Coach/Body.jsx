import React from "react";

import coach from "../../../css/coach.jpg"
import Title from "./Title";
import Description from "./Description";
import {AddOffer, ConsultOffers, ConsultClients} from "./Buttons";
import Paper from "@mui/material/Paper";
import Grid from "@mui/material/Grid";
import { makeStyles  } from "@mui/styles";
import Table from "./TableClient.jsx/TableClient"
import Video from "./Video";
import Video2 from "./vide2.mp4";
import ProfilCard from "./ProfilCard"


const useStyles = makeStyles({
  root: {
    flexGrow: 1,
    position: "relative",
    width:"100%",
    
  },
  paper: {
    padding: 0,
    textAlign: "left",
    color: "theme.palette.text.secondary",
    backgroundColor: "transparent",
    boxShadow: "0 0 0 0 transparent",
    position: "absolute",
    alignItems: "center",
  },
  list: {
    listStyle: "none",
  },
  li: {
    marginTop: "50px",
    // position:"absolute",
  },
  liButton: {
    marginTop: "100px",
  },
  lii: {
  

    "& > *": {
      fontFamily: "Montserrat",
      fontWeight: 400,
    },
  },
  course: {
    marginTop: "4%",
    
  },
  marginAll: {
  
  }
});
function Body(props) {
  let style = useStyles();

  return (
    <div className={style.root} onMouseOver={props.onMouseOver}>
         <Grid container spacing={4} >
           <Grid item xs={12}></Grid>
           <Grid item xs={12}>   <Title  title="Hello coach!"/></Grid>
<Grid item xs={6}>
<ProfilCard
               
                name="Hajar DAMI"
                photo={coach}
               email="hajar.dami.14@gmail.com"
               speciality="athlete"
               level="3"

                /> 





</Grid>
<Grid item container xs={6}>
<Grid item>

<Description />
</Grid>

<Grid container spacing={12}><Grid item> </Grid>
<Grid item>     <AddOffer />

</Grid>

<Grid item xs={12}>     <p style={{
                    fontFamily: "Comfortaa",
                    lineHeight: "1,4",
        fontSize: "20px",
        fontWeight: "100",
   color:"black"

      }}> Your client are waiting for new session !
      Contact them now !</p></Grid>


</Grid>
</Grid>
<Grid item xs={12}>
<Table/>
</Grid>


         </Grid>
      </div>
  );
}
export default Body;
