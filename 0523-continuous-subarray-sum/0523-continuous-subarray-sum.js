/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var checkSubarraySum = function (nums, k) {
  const n = nums.length;

  const map = new Map();

  let prefSum = [nums[0]];

  for (let i = 1; i < n; i++) {
    prefSum.push(prefSum[i - 1] + nums[i]);
  }

  let sum = 0;

  for (let i = 0; i < n; i++) {
    sum += nums[i];
    const mod = sum % k;
    if (mod === 0 && i + 1 >= 2) return true;
    if (map.has(mod)) {
      const prevInd = map.get(mod);
      if (i - prevInd >= 2 && (sum - prefSum[prevInd]) % k == 0) return true;
    }
    if (!map.has(mod)) {
      map.set(mod, i);
    }
  }

  return false;
};
