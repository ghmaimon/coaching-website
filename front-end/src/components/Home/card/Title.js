import React from 'react';
import styled from "styled-components";

export default function Title(props) {

    const Container = styled.div`
        display: flex;
        justify-content: space-between;
        flex-direction: column;
        align-items: center;
        height: "50%";
        margin-bottom: 11.74px;
       
    `;

    const Img = styled.img`
        height: 93.92px;
        border-radius: 50%;
    
    `;

    const Name = styled.h3`
        font-size: 15px;
        font-weight: 600;
      
      text-align: center;
        }
    `;

    const Position = styled.p`
 
    text-align: center;
   
`;
    return (
        <Container  >
            <Img src={props.img} />
            <Name style={{
       
          fontSize: "20px",
         
          fontFamily: "Comfortaa",
         
         
          fontWeight: 550,}}>{props.name}</Name>
            <Position style={{
      color:"black"
       
      }} >Software Engineering Student at ENSIAS</Position>
        </Container>
    )
}
