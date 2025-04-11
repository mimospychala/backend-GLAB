import React, { useRef, useEffect, useState } from 'react';
import styles from './CommentBar.module.css';

export default function CommentBar() {
  const textareaRef = useRef(null);
  const [value, setValue] = useState('');

  useEffect(() => {
    const textarea = textareaRef.current;
    if (textarea) {
      textarea.style.height = 'auto'; 
      textarea.style.height = `${textarea.scrollHeight}px`; 
    }
  }, [value]);

  return (
    <textarea
      ref={textareaRef}
      className={styles.textArea}
      placeholder="Kommentar..."
      value={value}
      onChange={(e) => setValue(e.target.value)}
      rows={1}
    />
  );
}
