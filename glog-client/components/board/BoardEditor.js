import dynamic from 'next/dynamic';
import '@toast-ui/editor/dist/toastui-editor.css';

function BoardEditor() {
    const Editor = dynamic(
        () => import('@toast-ui/react-editor').then((m) => m.Editor),
        {
            ssr: false,
        }
    );

    return (
        <Editor
            nitialValue="hello react editor world!"
            previewStyle="vertical"
            height="600px"
            initialEditType="markdown"
            useCommandShortcut={true}
        />
    );
}

export default BoardEditor;
