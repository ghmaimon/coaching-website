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

function TrainingSessions(){
    let style = useStyles();
    return (
        <MyButton
            bgColor="#FBEEC1"
            fgColor="black"
            className={style.root}
            value="My Training Sessions"
            url="/training_sessions"
        />
    );
}
function MealPlans(){
    let style = useStyles();
    return (
        <MyButton
            bgColor="#FBEEC1"
            fgColor="black"
            className={style.root}
            value="My Meal Plans"
            url="/meal_plans"
        />
    );
}
export {TrainingSessions, MealPlans};