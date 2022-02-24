import React from "react";
import Grid from "@mui/material/Grid";
import MyOffers from "./MyOffers"
import "../../../css/App.css"
import Welcome from  "./welcome"
import OfferCard from "./OffersCard/OfferCard"
import coach from "../../../css/coach.jpg"
import AlLCards from "./OffersCard/AlLCards"
function ConsultOffer(props) {
  return ( <div>
      <Grid container >
          <Grid item xs={12}/>
          <Grid item xs={4}/>
          <Grid item xs={4}>

          <MyOffers/> </Grid>
          <Grid item xs={4}/>
          <Grid item xs={12}>
  <Welcome/>
  </Grid>   
  <Grid item xs={12}> <AlLCards/></Grid>
  </Grid>
 </div>
  );
}
export default ConsultOffer;
