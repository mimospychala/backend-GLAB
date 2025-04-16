
export default function Input({ label, error, ...props }) {
    return (
        <div>
            <label>
                {label}
                <input {...props} />
                {error && <div className={styles.error}>{error}</div>}
            </label>
        </div>
    )
}
