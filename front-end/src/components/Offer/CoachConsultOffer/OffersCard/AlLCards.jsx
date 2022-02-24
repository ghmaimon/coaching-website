import React, { useState, useEffect } from "react";
import photo from "./coach.jpg";
import styled from "styled-components";
import Grid from "@mui/material/Grid";

import OfferCard from "./OfferCard"
 function AlLCards(props){
   function test()
   { alert('delete');}
/*data from back normallly*/
    let [courses, setcourses] = useState({ data: [{
      title:"Offer title" ,
      name:"coah name",
       image:photo ,
       desc:"The following demo doesn't follow the Material Design guidelines, but illustrates how the grid can be used to build complex layouts.Standard license",
       delete: test,
       client:"/client",
      price:"79$" }, {
        title:"Offer title" ,
        name:"coah name",
         image:photo ,
         desc:"The following demo doesn't follow the Material Design guidelines, but illustrates how the grid can be used to build complex layouts.Standard license",
  
        price:"79$"},
      {            title:"Offer title" ,
      name:"coah name",
       image:photo ,
       desc:"The following demo doesn't follow the Material Design guidelines, but illustrates how the grid can be used to build complex layouts.Standard license",

      price:"79$"  },
      {           title:"Offer title" ,
      name:"coah name",
       image:photo ,
       desc:"The following demo doesn't follow the Material Design guidelines, but illustrates how the grid can be used to build complex layouts.Standard license",

      price:"79$"   },
      {          title:"Offer title" ,
      name:"coah name",
       image:photo ,
       desc:"The following demo doesn't follow the Material Design guidelines, but illustrates how the grid can be used to build complex layouts.Standard license",

      price:"79$"   },
      
    ] });

     return( <Grid    container
        direction="row"
        justifyContent="center"
        alignItems="center" justifyContent="space-between" spacing={4}>

{
courses.data.map((card) => (
    <div>
        
          <Grid item  container  spacing={12} xs={12}>
          <Grid item xs={12}></Grid>
      <Grid item xs={2}></Grid>
    <Grid item xs={10}>
        <OfferCard
                price={card.price}
                name={card.name}
                desc={card.desc}
                image={card.image} 
                title={card.title}
                delete={card.delete}    client={card.client}/> 
            
        
        </Grid>  </Grid></div>))}

        <Grid item xs={3}>
       
        </Grid>
        
        </Grid>)




 }
 export default AlLCards;
 