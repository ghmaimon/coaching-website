import React from "react";
import Img,{QuoteImage} from "./Img";
import Title from "./Title";
import Description from "./Description";
import {TrainingSessions, MealPlans} from "./Buttons";
import Paper from "@mui/material/Paper";
import Grid from "@mui/material/Grid";
import { makeStyles  } from "@mui/styles";
import Search from "./Search";
import  AlLCards from "./Trainers/AlLCards";
import ChooseOffer from "./ChooseOffer";
       
const useStyles = makeStyles({
  root: {
    flexGrow: 1,
    position: "relative",
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
    marginTop: "40%",
    marginLeft: "10%",

    "& > *": {
      fontFamily: "Montserrat",
      fontWeight: 400,
    },
  },
  course: {
    marginTop: "4%",
    marginLeft: "5%",
  },
  marginAll: {
    marginLeft: "5%",
    marginTop: "4%",
  }
});
function Body(props) {
  let style = useStyles();

  return (
    <div >
   
      <div className={style.root} onMouseOver={props.onMouseOver}>
        <ol className={style.list}>
          <li className={style.li}>
            <Grid container spacing={1} justify="space-around">
              <Grid item xs={6} className={style.marginAll}>
                <Paper className={style.paper}>
                  <li className={style.li} >
                    <Title  title=" Welcome back  !"/>
               
        
                  </li>
                  <ol className={style.list}>
                  <ChooseOffer/>
                    <li className={style.li}>
                   < AlLCards/>
                  
               
                    </li>
                 
                  </ol>
                </Paper>
              </Grid>
              <Grid item xs={5} style={{marginTop:"5%",position:"absolute", right:"30%"}}>
              
              </Grid>
            </Grid>
          </li>
        </ol>
      </div>
    
    </div>
  );
}
export default Body;
