import React from "react";

function Description(props) {
    return (
        <div>
            <p
                style={{
                    fontFamily: "Comfortaa",
                    lineHeight: "2",
        fontSize: "20px",
        fontWeight: "100",
   color:"black",
   fontStyle: "oblique",
                }}
            >
             {props.desc}
            </p>
        </div>
    );
}

export default Description;
