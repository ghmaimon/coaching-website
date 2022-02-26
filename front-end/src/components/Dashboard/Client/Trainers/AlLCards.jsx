import React, { useState, useEffect } from "react";
import photo from "./coach.jpg";
import styled from "styled-components";
import Grid from "@mui/material/Grid";

import TrainerCard from "./TrainerCard"
import {getAllOffers, getMyOffers} from "../../../../service/offer";
 function AlLCards(props){
/*data from back normallly*/
     let [courses, setCourses] = useState({data : ""});
     useEffect(() => {
         return () => {
             if (courses.data === "")
                 getAllOffers(setCourses);
         };
     },[courses.data]);

     return( <Grid    container
        direction="row"
        justifyContent="center"
        alignItems="center" spacing={4}>

         {courses.data === "" ? <>
             <div style={{display: "none"}}>{getAllOffers(setCourses)} </div>
             <h1>loading</h1> </> : <>
         {
courses.data.map((card) => (
    <Grid item xs={3}>
        <TrainerCard
            url = {"/offer/"+card.id}
            id={card.id}
            price={card.minPrice}
            name={card.coachBasicDTO.firstName + " " + card.coachBasicDTO.lastName}
            desc={card.description}
            image={"http://localhost:8000/api/document/" + card.image}
            title={card.title}
            client={card.client}
        />


        </Grid>))}</>
         }

        <Grid item xs={3}>

        </Grid>

        </Grid>)




 }
 export default AlLCards;
 