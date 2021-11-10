import React from 'react';
import styled from 'styled-components';

const ChangeName = () => {
    return (
        <UpdateName>
            <Text>이름</Text>
            <UpdateInfo>
                <Text>수정</Text>
            </UpdateInfo>
        </UpdateName>
    );
};

const UpdateName = styled.div`
    width: 550px;
    height: 230px;
    padding-left: 30px;
    border-left: 1px solid gray;
`;

const UpdateInfo = styled.div`
    color: green;
    text-decoration: underline;
    :hover {
        cursor: pointer;
        opacity: 0.5;
    }
`;

const Text = styled.div`
    margin: 20px auto;
    margin-right: 87%;
`;

export default ChangeName;
