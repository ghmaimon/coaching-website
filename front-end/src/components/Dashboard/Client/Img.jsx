import React from "react";
import {Hidden} from "@mui/material";
import man_training from "../../../css/tarinning_wom.png";
import quote_image from "../../../css/quote.jpg";
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
                      
                        background: "transparent",
                        marginTop: "100px",
                        clipPath: "circle()",
                    }}
                />
            </Hidden>
        </>
    );
}
function QuoteImage() {
    return <>
        <Hidden mdDown>
            <img
                src={quote_image}
                alt="smile"
                style={{
                    position: "absolute",
                    width: "100%",
                    height: "600px",
                    background: "transparent",
                    marginTop: "460px",
                }}
            />
        </Hidden>
    </>;
}
export default Img;
export {QuoteImage};