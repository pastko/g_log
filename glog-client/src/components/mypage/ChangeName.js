import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import { history } from '../../store/configureStore';
import { useSelector, useDispatch } from "react-redux";

const ChangeName = () => {
    const dispatch = useDispatch();
    const users = useSelector((state) => state.user.user);
    const [name, setName] = useState('');
   
    // useEffect(() => {
    //     const getName = async () => {
    //         const res = await axios.get(`/myinfo`, {
    //             headers: {
    //                 Authorization: `Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJtYWlsIjoiZ2xvZ0BnbWFpbC5jb20iLCJwd2QiOiIiLCJzdWIiOiIkMmEkMTAkUURSTDc2Mm04bWJQWGV5M2hDZ0xaLk5rbWVYRjFzWGNJcHg3bGdTdHltUnhTbFBad01hcUsiLCJpYXQiOjE2MzY2MzY4ODMsImV4cCI6MTYzNjYzNzA2M30.ZvD-0MHC5Pg6q498hc9q8LqvBUqJKlhT7mJGDrOMHuMzQC9ZzDQpm8JhQ1jk4A70rMut7njae2KP47A9h-MOtg`,
    //                 'X-USER-ID': 'glog@gmail.com',
    //                 withCredentials: false,
    //                 'Access-Control-Allow-Origin': '*',
    //             },
    //         });
    //         console.log(res.data);
    //         setName(res.data);
    //     };
    //     getName();
    // }, []);

    return (
        <UpdateName>
            <Text>{users.nikNm}</Text>
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
