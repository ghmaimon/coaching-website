import React, {useState, useEffect} from "react";
import photo from "./coach.jpg";
import styled from "styled-components";
import Grid from "@mui/material/Grid";

import OfferCard from "./OfferCard"
import {getMyOffers} from "../../../../service/offer";

function AlLCards(props) {
    function test() {
        alert('delete');
    }

    /*data from back normallly*/

    let [courses, setCourses] = useState({data: ""});
    useEffect(() => {
        return () => {
            if (courses.data === "")
                getMyOffers(setCourses);
        };
    }, [courses.data]);

    return (<Grid container
                  direction="row"
                  justifyContent="center"
                  alignItems="center" justifyContent="space-between" spacing={4}>
        {courses.data === "" ? <>
            <div style={{display: "none"}}>{getMyOffers(setCourses)} </div>
            <h1>loading</h1> </> : <>
            {

                courses.data.map((card) => {
                    console.log("card" + card);
                    return (
                        <div>

                            <Grid item container spacing={12} xs={12}>
                                <Grid item xs={12}></Grid>
                                <Grid item xs={2}></Grid>
                                <Grid item xs={10}>
                                    <OfferCard
                                        id={card.id}
                                        price={card.minPrice}
                                        name={card.coachBasicDTO.firstName + " " + card.coachBasicDTO.lastName}
                                        desc={card.description}
                                        image={"http://localhost:8000/api/document/" + card.image}
                                        title={card.title}
                                        client={card.client}
                                    />


                                </Grid> </Grid></div>)
                })}
        </>
        }

        <Grid item xs={3}>

        </Grid>

    </Grid>)


}

export default AlLCards;
 