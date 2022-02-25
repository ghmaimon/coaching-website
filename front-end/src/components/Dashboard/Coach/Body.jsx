import React, {useEffect, useState} from "react";

import coach from "../../../css/coach.jpg"
import Title from "./Title";
import Description from "./Description";
import {AddOffer, ConsultOffers, ConsultClients} from "./Buttons";
import Paper from "@mui/material/Paper";
import Grid from "@mui/material/Grid";
import {makeStyles} from "@mui/styles";
import Table from "./TableClient.jsx/TableClient"
import Video from "./Video";
import Video2 from "./vide2.mp4";
import ProfilCard from "./ProfilCard"
import {getCoachData} from "../../../service/personalData";


const useStyles = makeStyles({
    root: {
        flexGrow: 1,
        position: "relative",
        width: "100%",

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
    marginAll: {}
});

function Body(props) {
    let style = useStyles();
    let [gotResult, setGotResult] = useState(false);
    let [fullName, setFullName] = useState("");
    let [image, setImage] = useState("");
    let [email, setEmail] = useState("");
    let [speciality, setSpeciality] = useState([]);

    if (gotResult !== true)
        getCoachData(setGotResult, setFullName, setImage, setEmail, setSpeciality);
    // useEffect(
    //     ()=>{
    //         if (gotResult !== true || results !== undefined){
    //
    //         }
    //     },[results,gotResult]
    // )

    return (<>
            {fullName === "" || image === ""  || email === ""  ? <div>Loading</div> :
                <div className={style.root} onMouseOver={props.onMouseOver}>
                    <Grid container spacing={4}>
                        <Grid item xs={12}></Grid>
                        <Grid item xs={12}> <Title title="Hello coach!"/></Grid>
                        <Grid item xs={6}>
                            <ProfilCard

                                name={fullName}
                                photo={"http://localhost:8000/api/document/"+image}
                                email={email}
                                speciality={speciality}
                                level="1"
                            />


                        </Grid>
                        <Grid item container xs={6}>
                            <Grid xs={12} item>

                                <Description/>
                            </Grid>

                            <Grid container xs={12}>
                                <Grid item xs={2}></Grid>
                                <Grid item xs={4}> <AddOffer/> </Grid>

                                <Grid xs={4} item>
                                    <ConsultOffers/>
                                </Grid>
                            </Grid>

                        </Grid>
                    </Grid>
                </div>}</>
    );
}

export default Body;
