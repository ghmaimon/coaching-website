import React from "react";
import MyButton from "../../../shared/MyButton";
import ButtonLogin from "../../../shared/ButtonLogin";
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

function TrainingSessions(){
    let style = useStyles();
    return (
        <ButtonLogin
           
            name="My Training Sessions"
            href="/training_sessions"
        />
    );
}
function MealPlans(){
    let style = useStyles();
    return (
        <ButtonLogin
        
        name="My Meal Plans"
        href="/meal_plans"
        />
    );
}
export {TrainingSessions, MealPlans};