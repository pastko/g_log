import React from 'react';
import styled from 'styled-components';
import ChangeImage from '../../components/mypage/ChangeImage';
import ChangeName from '../../components/mypage/ChangeName';
import ChangeTitle from '../../components/mypage/ChangeTitle';
import UserDelete from '../../components/mypage/UserDelete';

const Profile = () => {
    return (
        <>
            <ProfileWrap>
                <ChangeImage />
                <ChangeName />
            </ProfileWrap>
            <ChangeTitle />
            <UserDelete />
        </>
    );
};

const ProfileWrap = styled.div`
    max-width: 770px;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    box-sizing: border-box;
    margin: auto;
    margin-top: 1rem;
    max-height: 310px;
    height: 100%;
    border: 1px solid red;
`;

export default Profile;
