import React from "react";

import feuille from "../../../css/feuille.png"
import iversefeuille from "../../../css/feuilleinv.png"
import { makeStyles } from "@mui/styles";
import "../../../css/App.css"
import { Grid } from "@mui/material";
import {TrainingSessions, MealPlans} from "./Buttons";


const useStyles = makeStyles({
  butt1: {
    float: "left",
    position: "absolute",

    fontFamily: "Cascadia Code",
    marginTop: "50%"
  },
  butt2: {
    float: "left",
    position: "absolute",

    fontFamily: "Cascadia Code",
  },

  inversefeuille: {

    height: "30px"

  }
});
function ChooseOffer() {
  let style = useStyles();
return(
<Grid  container>
  <Grid item container md={2} xs={2}></Grid>
          <Grid item  container md={1} xs={1} >  
            <img src={iversefeuille} alt="feuille" className={style.inversefeuille} />
          </Grid>

          <Grid item  container md={3} xs={3} >   <p style={{
            fontFamily: "Rubik Beastly",
            marginLeft:"20",
            lineHeight: "1,4",
            fontSize: "20px",
            fontWeight: "100",
            marginTop: "10%",
            color:"rgba(15, 103, 8, 1)"

          }}>Contact your preffered coach </p>
          </Grid>
          <Grid item md={1} xs={1} > <img src={feuille} alt="feuille" height="30px" className={style.feuille} /></Grid>
          <Grid item container md={3} xs={3}></Grid>

        </Grid>)
        
        ;}
        export default ChooseOffer;