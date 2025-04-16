import React, { useRef, useEffect, useState } from 'react';
import styles from './CommentBar.module.css';

export default function CommentBar({ func }) {
  const textareaRef = useRef(null);
  const [value, setValue] = useState('');

  useEffect(() => {
    const textarea = textareaRef.current;
    if (textarea) {
      textarea.style.height = 'auto';
      textarea.style.height = `${textarea.scrollHeight}px`;
    }
  }, [value]);

  const handleChange = (e) => {
    const newValue = e.target.value;
    setValue(newValue);
    if (func) func(newValue); 
  };

  return (
    <textarea
      ref={textareaRef}
      className={styles.textArea}
      placeholder="Kommentar..."
      value={value}
      onChange={handleChange}
      rows={1}
    />)
}
