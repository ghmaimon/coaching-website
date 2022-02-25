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

function ContactCoach(props){
    let style = useStyles();
    return (
        <ButtonLogin
            style={{
             
            }}
        name="Contact Coach"
     
        onClick={() => window.open("mailto:"+props.email)}
        />
    );
}
function JoinOffer(){
    let style = useStyles();
    return (
        <ButtonLogin
       
        name="join the offer"
        href="/jointheoffer"
        />
    );
}
function Payment(){
    let style = useStyles();
    return (
        <ButtonLogin
       
        name="Payment"
        href="/Payment"
        />
    );
}
export {JoinOffer, Payment, ContactCoach};