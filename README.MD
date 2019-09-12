# SUDOKU VERIFIER

## Approach

1. Check if puzzle is at least 81 number long (number after pos 81 are ignored)
2. Parse one number at at time
    - calculate row number, column number and block number
    - in given row, column and block increase the counter for parsed number by 1
3. When all numbers are read then verify every row, column and block
    - if any counter is > 1 then given segment is invalid
4. Count all the invalid segments
    - if number of invalid segments > 0 then puzzle is invalid
    
## Time complexity (simplified)
Reading numbers: `~ n` \
Verifying rows: `~ n` \
Veryfing columns: `~ n` \
Veryfing blocks: `~ n` \
Total: `4n ~ n`
