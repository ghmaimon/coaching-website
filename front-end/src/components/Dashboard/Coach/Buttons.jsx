import React from "react";
import MyButton from "../../../shared/MyButton";
import { makeStyles } from "@mui/styles";
const useStyles = makeStyles({
    root: {
        float: "left",
        position: "absolute",
        marginLeft: "12%",
        fontFamily: "Cascadia Code",
    },
    secondary: {
        float: "left",
        position: "absolute",
        marginLeft: "12%",
        fontFamily: "Cascadia Code",
        paddingRight: "2%",
    },
    third: {
        float: "left",
        position: "absolute",
        fontFamily: "Cascadia Code",
        paddingRight: "2%",
    },
});

function AddOffer(){
    let style = useStyles();
    return (
        <MyButton
            bgColor="#FBEEC1"
            fgColor="black"
            className={style.root}
            value="Add Offer"
            url="/add_offer"
        />
    );
}
function ConsultClients(){
    let style = useStyles();
    return (
        <MyButton
            bgColor="#FBEEC1"
            fgColor="black"
            className={style.root}
            value="Consult My Clients"
            url="/clients"
        />
    );
}
function ConsultOffers(){
    let style = useStyles();
    return (
        <MyButton
            bgColor="#FBEEC1"
            fgColor="black"
            className={style.root}
            value="Consult My Offers"
            url="/offers"
        />
    );
}
export {AddOffer, ConsultOffers, ConsultClients};