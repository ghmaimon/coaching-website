import React from "react";
import {Hidden} from "@mui/material";
import man_training from "../../../css/fitness_stuff.png";

function Img() {
    return (
        <>
            <Hidden mdDown>
                <img
                    src={man_training}
                    alt="smile"
                    style={{
                        position: "absolute",
                        width: "250px",
                        height: "300px",
                        transform: "rotate(9.63deg)",
                        background: "transparent",
                        marginTop: "100px",
                        clipPath: "circle()",
                    }}
                />
            </Hidden>
        </>
    );
}

export default Img;
