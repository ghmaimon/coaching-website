import React from "react";
import {Hidden} from "@mui/material";
import tarinning_wom from "../../../css/tarinning_wom.png";

function Img() {
    return (
        <>
            <Hidden mdDown>
                <img
                    src={tarinning_wom}
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
