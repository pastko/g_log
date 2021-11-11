import React, { useEffect, useState } from 'react';
import InfiniteScroll from 'react-infinite-scroll-component';
import Post from '../components/main/Post';
import styled from 'styled-components';
import axios from 'axios';

const Home = () => {
    const [items, setItems] = useState([]);
    const [noMore, setnoMore] = useState(true);
    const [page, setpage] = useState(2);

    // useEffect(() => {
    //     const getComments = async () => {
    //         // const res = await fetch(
    //         //     `http://localhost:3004/comments?_page=1&_limit=20`
    //         // );
    //         // const data = await res.json();
    //         // setItems(data);
    //         const res = await axios.get(
    //             `http://localhost:3004/comments?_page=1&_limit=20` //서버에서 api 받아올 예정
    //         );
    //         setItems(res.data);
    //     };
    //     getComments();
    // }, []);

    // const fetchComments = async () => {
    //     // const res = await fetch(
    //     //     `http://localhost:3004/comments?_page=${page}&_limit=20`
    //     // );
    //     // const data = await res.json();
    //     // return data;
    //     const res = await axios.get(
    //         `http://localhost:3004/comments?_page=${page}&_limit=20` //서버에서 api 받아올 예정
    //     );
    //     return res.data;
    // };
    const fetchData = async () => {
        const commentsFormServer = await fetchComments();
        setItems([...items, ...commentsFormServer]);

        if (commentsFormServer.length === 0 || commentsFormServer.length < 20) {
            setnoMore(false);
        }
        setpage(page + 1);
    };

    return (
        <>
            {/* <Recent>
                <TrandTab>
                    <text> 트렌딩 </text>
                </TrandTab>
                <NewTab>
                    <text> 최신 </text>
                </NewTab>
            </Recent> */}
            <StyleInfiniteScroll>
                <InfiniteScroll
                    dataLength={items.length} //This is important field to render the next data
                    next={fetchData}
                    hasMore={noMore}
                >
                    {items.map((item) => {
                        return <Post key={item.id} item={item} />;
                    })}
                </InfiniteScroll>
            </StyleInfiniteScroll>
        </>
    );
};

const Recent = styled.div`
    max-width: 1280px;
    font-size: 18px;
    color: rgb(134, 142, 150);
    margin-right: 40%;
    margin-bottom: -20px;
`;

const TrandTab = styled.div`
    display: inline-block;
    height: 0px;
    width: 53px;
    margin-left: -30%;
    margin-bottom: -15%;
`;

const NewTab = styled.div`
    display: inline-block;
    width: 35px;
    height: 0px;
    margin: 5px;
    margin-top: -1%;
`;

const StyleInfiniteScroll = styled.div`
    max-width: 1280px;
    margin: 20px auto;
    position: flex;
    transform: translate(9.5%);
`;

export default Home;

