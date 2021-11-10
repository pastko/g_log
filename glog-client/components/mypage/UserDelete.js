import React from 'react';
import styled from 'styled-components';

const UserDelete = () => {
    return (
        <DeleteUser>
            <DeleteMain>
                <DeleteWrap>
                    <UserEdit> 회원탈퇴 </UserEdit>
                    <Deletebtn>
                        <Btn> 회원탈퇴 </Btn>
                    </Deletebtn>
                </DeleteWrap>
            </DeleteMain>
        </DeleteUser>
    );
};

const DeleteUser = styled.div`
    max-width: 770px;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    box-sizing: border-box;
    margin: 20px auto;
    margin-top: 1rem;
    height: 100%;
`;

const DeleteMain = styled.div`
    padding-top: 1rem;
    padding-bottom: 0rem;
    width: 95%;
    border-bottom: 1px solid darkgray;
`;
const DeleteWrap = styled.div`
    height: 20px;
    padding-bottom: 15px;
`;

const UserEdit = styled.div`
    width: 9.5rem;
`;

const Deletebtn = styled.div`
    align-items: center;
    width: 500px;
    margin-top: -20.5px;
    margin-left: 14rem;
    height: 20px;
    display: flex;
`;

const Btn = styled.div`
    background-color: red;
    color: white;
    font-size: 1rem;
    border-radius: 4px;
    line-height: 1.5;
    justify-content: flex-start;
    width: 75px;
    align-items: center;
    :hover {
        cursor: pointer;
        opacity: 0.5;
    }
`;

export default UserDelete;
