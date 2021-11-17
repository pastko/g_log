import React, { useEffect, useState } from 'react';
import InfiniteScroll from 'react-infinite-scroll-component';
import Post from '../components/main/Post';
import styled from 'styled-components';
import axios from 'axios';

const Home = () => {
    const [posts, setPosts] = useState([]);
    const [noMore, setnoMore] = useState(true);
    const [page, setpage] = useState(2);
    console.log(posts);
    useEffect(() => {
        const getComments = async () => {
            const res = await axios.get(
                '/board?pageNum=0&sortRule=1',{
                    withCredentials: true
                }
            );
            console.log(res);

            setPosts(res.data.data);
        };
        getComments();
    }, []);

    const fetchComments = async () => {
        const res = await axios.get(
            `/board?pageNum=${page}&sortRule=1`,{
                withCredentials: true
            }
        );
        console.log(res);
        return res.data.data;
    };
    const fetchData = async ()=>{
        const postsFormServer = await fetchComments();
        setPosts([...posts, ...postsFormServer]);

        if (postsFormServer.length === 0 || postsFormServer.length < 10) {
            setnoMore(false);
        }
        setpage(page + 1);
    };

    return (
        <>
            <StyleInfiniteScroll>
                <InfiniteScroll
                    dataLength={posts.length} //This is important field to render the next data
                    next={fetchData}
                    hasMore={noMore}
                >
                    {Post.length === 0 ? 'Emtpy' : posts.map((post) => {
                        return <Post key={posts.idx} post={post} />;
                    })}
                </InfiniteScroll>
            </StyleInfiniteScroll>
        </>
    );
};

const StyleInfiniteScroll = styled.div`
    max-width: 1280px;
    margin: 20px auto;
    position: flex;
    transform: translate(9.5%);
`;

export default Home;
