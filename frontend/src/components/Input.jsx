import styles from "./Input.module.css"

export default function Input({ label, error, ...props }) {
    return (
        <div className={styles.wrapper}>
            <label className={styles.label}>
                {label}
                <input className={styles.input} {...props} />
                {error && <div className={styles.error}>{error}</div>}
            </label>
        </div>
    )
}
