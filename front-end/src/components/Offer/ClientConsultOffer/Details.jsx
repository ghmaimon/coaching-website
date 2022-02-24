import React from "react";

import ConsultOffer from "./ConsultOffer";
import coach from  "../../../css/coach.jpg"

function Details(props) {
    return(
    <ConsultOffer title="offerTitle" desc="Experts define physical fitness as “one’s ability to execute daily activities with optimal performance, endurance, and strength with the management of disease, fatigue, and stress and reduced sedentary behavior.”

    This description goes beyond being able to run quickly or lift heavy weights. Despite being important, these attributes only address single areas of fitness.
    
    This article provides details of the five main components of physical fitness."
    
    name="Hajar DAMI"
               photo={coach}
              email="hajar.dami.14@gmail.com"
              speciality="athlete"
              level="3"

              date="20/12/2022" maxPrice="30$" minPrice="20$"/>


    );
}
export default Details;
