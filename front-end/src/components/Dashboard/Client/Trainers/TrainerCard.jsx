import React from "react";
import hajar_photo from "../../../../css/coach.jpg";
import styled from "styled-components";
import TextButton from "../../../../shared/TextButton"
 function TrainerCard(props){
  const Container = styled.div`
 width: 100%;
  max-width: 80%;
  
  background:#FFFFFF;
  padding: 44px;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
  text-align: left;
  border-radius: 4px;
  
 
`;

const Img = styled.img`
display: block;
  margin-left: auto;
  margin-right: auto;
 height: 100px;
 width: 150px;
  



`;

const Test1 = styled.h5`
color: #ed563b;
margin: 26px 0 9px 0;
font-weight: 500;
font-size: 14px
 
`;

const Test2 = styled.h3`
color: rgba(15, 103, 8, 1);
letter-spacing: 1px;
fontFamily: "Rubik Beastly";
  }
`;

const Test3 = styled.p`
margin: 24px 0 28px 0;
    color: #7a7a7a;
    font-size: 15px;
    font-weight: 400;
    line-height: 1.7;
    
overflow: hidden;

display: -webkit-box;
-webkit-line-clamp: 3;
-webkit-box-orient: vertical;
  

    

`; 
return (
  <Container>
<Test2>{props.name}</Test2>
 <Img   src={props.image} alt="trainer" />
    <Test3>{props.desc}</Test3>
    <Test1>{props.price}</Test1>

 < TextButton value="Details"  fgColor="rgba(15, 103, 8, 1)"  url={props.url}> </TextButton>
  
   </Container>);
}


export default TrainerCard;

