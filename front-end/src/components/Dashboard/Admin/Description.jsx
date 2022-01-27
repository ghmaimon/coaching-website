import React from "react";

export default function Description() {
    // to be set using axios from backend
    let numberOfDocumentsToVerify = 0;
    let numberOfDisputesToResolve = 0;
  return (
    <div>
      <p
        style={{
          width: "40%",
          marginLeft: "10%",
          fontFamily: "Comfortaa",
          lineHeight: "1.6",
          fontSize: "17px",
        }}
      >
          You have : <br/>
          <ul>
              <li>{numberOfDocumentsToVerify} new documents to verify.</li>
              <li>{numberOfDisputesToResolve} new disputes to resolve.</li>
          </ul>
      </p>
    </div>
  );
}
