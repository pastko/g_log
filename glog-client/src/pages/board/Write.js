import { useState, useRef } from 'react';
import { useSelector } from 'react-redux';
import Tags from '../../components/board/Tags';
import Title from '../../components/board/Title';
import '@toast-ui/editor/dist/toastui-editor.css';
import { Editor } from '@toast-ui/react-editor';
import Button from '../../components/layout/Button';
import styled from 'styled-components';

function Write() {
    // const {name} = useSelector(state => {
    //     console.log('state :: ', state);
    // })

    const [title, setTitle] = useState('');
    const [hashTags, setHashTags] = useState([]);
    const editorRef = useRef();
    const goBoardSave = () => {
        const conetentHtml = editorRef.current.getInstance().getHtml();
        const contentMarkdown = editorRef.current.getInstance().getMarkdown();
        const image = conetentHtml.split('=')[1]?.split('"')[1];

        if(!contentMarkdown) return;

        const data = {
            title,
            content: contentMarkdown.replaceAll('#', ''),
            name: '',
            hashTag: hashTags,
            image: image
        }
    };

    return (
        <>
            <StyledWrapper>
                <StyledHeader>
                    <Title title={title} setTitle={setTitle} />
                    <Tags hashTags={hashTags} setHashTags={setHashTags}/>
                </StyledHeader>
                <Editor
                    placeholder="당신의 이야기를 시작하세요!"
                    height="62vh"
                    minHeight="300px"
                    previewStyle="vertical"
                    initialEditType="markdown"
                    useCommandShortcut={true}
                    previewHighlight={false}
                    ref={editorRef}
                />
                <StyledBottom>
                    <Button isDefault children="나가기" />
                    <div className="right">
                        <Button children="출간하기" _onClick={goBoardSave} />
                    </div>
                </StyledBottom>
            </StyledWrapper>
        </>
    );
}

const StyledWrapper = styled.div`
    width: 100%;
    height: 100%;
    min-height: 0px;
    display: flex;
    flex-direction: column;
`;

const StyledHeader = styled.div`
    height: 30vh;
`;

const StyledBottom = styled.div`
    width: 100%;
    height: 8vh;
    position: fixed;
    bottom: 0px;
    z-index: 10;
    padding: 0 20px;
    box-shadow: #00000028 0px 0px 8px;
    background: #ffffffc5;
    display: flex;
    align-items: center;
    justify-content: space-between;
`;

export default Write;
