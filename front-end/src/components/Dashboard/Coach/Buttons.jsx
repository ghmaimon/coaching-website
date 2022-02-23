import React from "react";
import MyButton from "../../../shared/MyButton";
import { makeStyles } from "@mui/styles";
import ButtonLogin from "../../../shared/ButtonLogin"
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
        <ButtonLogin
            style={{
             
            }}
        name="Add Offer"
        href="/add_offer"
        />
    );
}
function ConsultClients(){
    let style = useStyles();
    return (
        <ButtonLogin
       
        name="Consult My Clients"
        href="/clients"
        />
    );
}
function ConsultOffers(){
    let style = useStyles();
    return (
        <ButtonLogin
           
        name="Consult My Offers"
            href="/offers"
        />
    );
}
export {AddOffer, ConsultOffers, ConsultClients};