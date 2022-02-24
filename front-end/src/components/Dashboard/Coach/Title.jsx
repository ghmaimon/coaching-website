import React from "react";
import feuille from "../../../css/feuille.png"
import iversefeuille from "../../../css/feuilleinv.png"
import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";

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

function Title(props) {
  let style = useStyles();
  return (
    
    <Grid  container >
 <Grid item  md={4} xs={4}></Grid>
      <Grid item  container md={1} xs={1} >  
        <img src={iversefeuille} alt="feuille" className={style.inversefeuille} />
      </Grid>

      <Grid item  container md={3} xs={3}   justifyContent="space-between" 
 >   <p style={{
        fontFamily: "Rubik Beastly",
        lineHeight: "1,4",
        fontSize: "40px",
        fontWeight: "100",
        marginTop: "10%",
        color:"rgba(15, 103, 8, 1)"

      }}> {props.title} </p>
      </Grid>
      <Grid item md={1} xs={1} > 
      <img src={feuille} alt="feuille" height="30px" className={style.feuille} /></Grid>
      <Grid item  md={3} xs={3}></Grid>
    
    </Grid>
  );
}
export default Title;
