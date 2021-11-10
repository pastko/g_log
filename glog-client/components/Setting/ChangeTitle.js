import React from 'react';
import styled from 'styled-components';

const ChangeInfo = () => {
    return (
        <UserInfo>
            <Title>
                <TitleWrap>
                    <UserInfoText>Glog Title</UserInfoText>
                    <UpdateName>
                        <ChangeName>변경할 이름</ChangeName>
                        <NameButton>수정</NameButton>
                    </UpdateName>
                </TitleWrap>
            </Title>
        </UserInfo>
    );
};

const UserInfo = styled.div`
    max-width: 770px;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    box-sizing: border-box;
    margin: 20px auto;
    height: 80px;
    margin-top: 1rem;
    height: 100%;
`;

const Title = styled.div`
    padding-top: 1rem;
    padding-bottom: 0rem;
    width: 95%;
    border-bottom: 1px solid darkgray;
`;

const TitleWrap = styled.div`
    height: 20px;
    padding-bottom: 15px;
`;

const UserInfoText = styled.div`
    width: 9.5rem;
`;

const UpdateName = styled.div`
    align-items: center;
    width: 500px;
    margin-top: -20.5px;
    margin-left: 14rem;
    height: 20px;
    display: flex;
`;

const ChangeName = styled.div`
    font-size: 1rem;
    line-height: 1.5;
    justify-content: flex-start;
    width: 75px;
`;

const NameButton = styled.div`
    align-items: center;
    margin-left: 24rem;
    color: green;
    text-decoration: underline;
    :hover {
        cursor: pointer;
        opacity: 0.5;
    }
`;
export default ChangeInfo;
