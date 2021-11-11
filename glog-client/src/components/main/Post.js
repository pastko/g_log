import React from 'react';
import styled from 'styled-components';

//출력될 코멘트

const Post = ({ post: { titl, cont, cret_dt } }) => {
    return (
        <Wrap>
            <ImageBtn>이미지</ImageBtn>
            <Description>
                <TextWrap>
                    <Title>Title : {titl} </Title>
                    <Text> Content : {cont} </Text>
                </TextWrap>
                <Date>{cret_dt}</Date>
                <Comment>댓글</Comment>
            </Description>
            <UserName>
                by <span>이메일</span>
            </UserName>
        </Wrap>
    );
};

export default Post;

//각 게시물 스타일 변경
const Wrap = styled.div`
    float: left;
    display: flex;
    flex-wrap: wrap;
    gap: auto;
    max-width: 1024px;
    position: relative;
    box-sizing: border-box;
    width: 320px;
    height: 377px;
    margin: 20px 10px;
    box-shadow: 0 0 5px #dbdbdb;
    background-color: #fff;
    // &:hover {                    //커서 올렸을때 커지는 반응
    //     margin-top: 2px;
    //     transition: all 0.3s ease-in-out;
    //     box-shadow: 0 5px 10px #dbdbdb;
    // }
`;

//이미지 부분 (버튼화)
const ImageBtn = styled.button`
    display: block;
    width: 100%;
    border: none;
    box-sizing: border-box;
    background-color: transparent;
    cursor: pointer;
    padding: 0;
`;

const Description = styled.div`
    box-sizing: border-box;
    width: 100%;
    height: 165px;
    padding: 0 16px;
`;
const TextWrap = styled.button`
    width: 100%;
    height: 118px;
    border: none;
    box-sizing: border-box;
    background-color: transparent;
    cursor: pointer;
    text-align: left;
    padding: 0;
    word-break: break-all;
`;
const Title = styled.h2`
    font-size: 16px;
    margin: -24px 0 8px 0;
`;
const Text = styled.p`
    font-size: 14px;
    line-height: 1.7;
    margin: 0;
`;
const Date = styled.span`
    font-size: 12px;
    color: rgb(134, 142, 150);
`;
const Comment = styled.span`
    font-size: 12px;
    color: rgb(134, 142, 150);
`;
const UserName = styled.div`
    position: absolute;
    bottom: 0;
    left: 0;
    width: 80%;
    border-top: 1px solid #e6e6e6;
    box-sizing: border-box;
    font-size: 14px;
    padding: 12px 16px;
`;

const LikeCount = styled.div`
    position: absolute;
    bottom: 0;
    right: 0;
    width: 30%;
    border-top: 1px solid #e6e6e6;
    box-sizing: border-box;
    font-size: 14px;
    padding: 12px 16px;
`;
