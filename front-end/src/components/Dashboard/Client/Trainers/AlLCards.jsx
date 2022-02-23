import React, { useState, useEffect } from "react";
import photo from "./coach.jpg";
import styled from "styled-components";
import Grid from "@mui/material/Grid";

import TrainerCard from "./TrainerCard"
 function AlLCards(props){
/*data from back normallly*/
    let [courses, setcourses] = useState({ data: [{
        price:"20$",
        name:"Coach name",
        image:photo,
     url:"/details",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      }, {
        image:photo,
        url:"/details",
        price:"20$",
        name:"Coach name",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      },
      {          image:photo,

      url:"/details",
        price:"20$",
        name:"Coach name",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      },
      {           image:photo,

      url:"/details",
        price:"20$",
        name:"Coach name",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      },
      {          image:photo,

      url:"/details",
        price:"20$",
        name:"Coach name",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      },
      {           image:photo,

      url:"/details",
        price:"20$",
        name:"Coach name",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      },
      {           image:photo,

      url:"/details",
        price:"20$",
        name:"Coach name",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      },
      {          image:photo,

      url:"/details",
        price:"20$",
        name:"Coach name",
        desc:"offer description offer description offer description offer description offer description offer description  offer description "
      },
    ] });

     return( <Grid    container
        direction="row"
        justifyContent="center"
        alignItems="center" spacing={4}>

{
courses.data.map((card) => (
    <Grid item xs={3}>
        <TrainerCard
                price={card.price}
                name={card.name}
                desc={card.desc}
                image={card.image} 
                url={card.url}/> 
                  
        
        </Grid>))}

        <Grid item xs={3}>
       
        </Grid>
        
        </Grid>)




 }
 export default AlLCards;
 