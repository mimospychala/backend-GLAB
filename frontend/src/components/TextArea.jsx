import styles from "./Textarea.module.css"

export default function Textarea({ label, error, rows = 10, ...props }) {
    return (
        <div className={styles.wrapper}>
            <label className={styles.label}>
                {label}
                <textarea className={styles.textarea} rows={rows} {...props} />
                {error && <div className={styles.error}>{error}</div>}
            </label>
        </div>
    )
}
