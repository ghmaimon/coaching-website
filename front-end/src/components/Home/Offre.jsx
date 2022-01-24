import React from "react";

import feuille from "../../css/feuille.png"
import iversefeuille from "../../css/feuilleinv.png"
import { makeStyles } from "@mui/styles";

import "../../css/App.css"
import { Grid } from "@mui/material";
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
function Offre(props) {
  let style = useStyles();
  return (
    <div>
      <Grid container>
        <Grid item md={4} xs={4} />
        <Grid item container md={4} xs={4}>
          <Grid item  >   <img src={iversefeuille} alt="feuille" className={style.inversefeuille} />
          </Grid>

          <Grid item  >   <p style={{
            fontFamily: "Rubik Beastly",


            lineHeight: "1,4",
            fontSize: "25px",

            fontWeight: "300",
            marginTop: "10%"

          }}>{props.title}</p>
          </Grid>
          <Grid item > <img src={feuille} alt="feuille" height="30px" className={style.feuille} /></Grid>
        </Grid>
        <Grid item md={4} xs={4} />
      </Grid>


    </div>
  );
}
export default Offre;
