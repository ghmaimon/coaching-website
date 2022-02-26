import React, {useEffect, useState} from "react";

import ConsultOffer from "./ConsultOffer";
import coach from  "../../../css/coach.jpg"
import {getAllOffers, getOffer} from "../../../service/offer";

function Details(props) {
    let [offer, setOffer] = useState({data : ""});
    if (offer.data === ""){
        getOffer( window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1), setOffer);
    }
    useEffect(() => {
        return () => {
            if (offer.data === "")
                getOffer( window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1), setOffer);
        };
    },[offer.data]);
    return(<>
        {offer.data === ""
                ?<h1>loading</h1>
                :
    <ConsultOffer title={offer.data.title} desc={offer.data.description}
    
    name={offer.data.coachBasicDTO.firstName + " "+offer.data.coachBasicDTO.lastName}
               photo={"http://localhost:8000/api/document/"+offer.data.image}
              email={offer.data.coachBasicDTO.email}
              // speciality="athlete"
              level="1"
              date={new Date(offer.data.creationDate).toLocaleDateString()}
                  maxPrice={offer.data.maxPrice + "$"}
                  minPrice={offer.data.minPrice + "$"}/>}</>


    );
}
export default Details;
