import React from "react";
import "../../css/Footer.css";
import Copyright from "../Copyright";
import Grid from "@mui/material/Grid";


function Footer() {

    return (
        <footer>
        <Grid container >
            <Grid item md={5} xs={5}/>
            <Grid item md={3} xs={3}><Copyright title="MEET FITNESS"/></Grid>
            <Grid item md={4} xs={4}/>
        </Grid></footer>
    );
}

export default Footer;