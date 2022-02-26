import React from "react";
import coach from "../../../css/coach.jpg";
import styled from "styled-components";
import TextButton from "../../../shared/TextButton"
 function ProfilCard(props){
  const Container = styled.div`
 width: 100%;
  width: 500px;
  
  padding: 44px;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
  text-align: left;
  border-radius: 4px;
  margin-left:20%
 
`;

const Img = styled.img`
  height: 100px;
  margin: 26px 257px 9px 150px;




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
  

    

`; 
return (
  <Container>
    
<Test2>Name :{props.name}</Test2>
 <Img   src={props.photo} alt="trainer" />
    <Test3>email : {props.email }</Test3>
    
    
    <Test1>My level :{props.level }</Test1>

 
  
   </Container>);
}


export default ProfilCard;

