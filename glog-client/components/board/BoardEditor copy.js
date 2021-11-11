import React, { useRef } from 'react';
import dynamic from 'next/dynamic';
import '@toast-ui/editor/dist/toastui-editor.css';
import BoardButton from './BoardButton';
import styled from 'styled-components';

function BoardEditor() {
    const Editor = dynamic(
        () => import('@toast-ui/react-editor').then((m) => m.Editor),
        {
            ssr: false,
        }
    );
    const editorRef = useRef();

    const handleClick = () => {
        debugger;
        console.log(editorRef.current.getInstance().getMarkdown());
    };

    return (
        <>
            <Editor
                placeholder="당신의 이야기를 적어보세요..."
                height="auto"
                minHeight="800px"
                previewStyle="vertical"
                initialEditType="markdown"
                useCommandShortcut={true}
                autofocus={true}
                scroll={true}
                ref={editorRef}
            />
            <StyledButtons>
                <BoardButton isDefault title="나가기" />
                <div className="right">
                    <BoardButton title="출간하기" onClick={handleClick} />
                </div>
            </StyledButtons>
        </>
    );
}

const StyledButtons = styled.div`
    width: 100%;
    height: 6%;
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

export default BoardEditor;
