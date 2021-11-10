import React from 'react';
import styled from 'styled-components';

const ChangeImage = () => {
    return (
        <ProfileImage>
            <StyledThumbnail> 이미지 </StyledThumbnail>
            <Button>
                <text> 이미지 업로드 </text>
            </Button>ß
            <Button>
                <text> 이미지 제거 </text>
            </Button>
        </ProfileImage>
    );
};

const ProfileImage = styled.div`
    width: 180px;
    height: 236px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
`;

const StyledThumbnail = styled.div`
    width: 180px;
    height: 300px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
`;

const Button = styled.div`
    background-color: green;
    color: white;
    width: 140px;
    border: none;
    font-size: 15px;
    font-weight: 600;
    border-radius: 8px;
    height: 35px;
    margin: 5px;
    display: flex;
    justify-content: center;
    align-items: center;
    :hover {
        cursor: pointer;
        opacity: 0.5;
    }
`;

export default ChangeImage;